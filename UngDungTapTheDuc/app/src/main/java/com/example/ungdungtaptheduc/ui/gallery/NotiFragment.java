package com.example.ungdungtaptheduc.ui.gallery;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ungdungtaptheduc.Database;
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.ui.home.HitDat;

import java.util.ArrayList;
import java.util.Calendar;

public class NotiFragment extends Fragment implements TimePickerDialog.OnTimeSetListener{
    private ImageButton imageButton;
    private CheckBox cbCN, cb2, cb3, cb4, cb5, cb6, cb7;
    boolean is24HView = true;
    private int lastSelectedHour = -1;
    private int lastSelectedMinute = -1;
    String hour, hourUpdate;
    String days;
    ListView lv_alarm;
    ArrayList<Alarm> listAlarm;
    AlarmListViewAdapter alarmListViewAdapter;
    Database db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_noti, container, false);
        imageButton = (ImageButton) root.findViewById(R.id.ImageButton_Add);

        listAlarm = new ArrayList<>();
        db = new Database(getContext(), "Workout.db", (SQLiteDatabase.CursorFactory) null, 1);
        loadAlarm();
        thongBao();
        alarmListViewAdapter = new AlarmListViewAdapter(listAlarm);
        lv_alarm = (ListView) root.findViewById(R.id.listView_alarm);
        lv_alarm.setAdapter(alarmListViewAdapter);

        lv_alarm.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Alarm alarm = (Alarm) alarmListViewAdapter.getItem(position);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), 2);
                alertDialogBuilder.setMessage("B???n c?? mu???n x??a ?");
                alertDialogBuilder.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        // x??a  ??ang nh???n gi???
                        db.deleteAlarm(alarm.id);
//                        //c???p nh???t l???i listview
                        alarmListViewAdapter.notifyDataSetChanged();
                        loadAlarm();
                    }
                });
                alertDialogBuilder.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //kh??ng l??m g??
                    }
                });
                alertDialogBuilder.show();
                return true;
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePickerDialog();
            }
        });

        return root;
    }
    private void thongBao() {
        final Calendar c = Calendar.getInstance();
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        int currentMinute = c.get(Calendar.MINUTE);

        listAlarm.clear();

        Cursor cursor = db.GetData("Select * from Alarm");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            int hour = cursor.getInt(1);
            int minute = cursor.getInt(2);
            String days = cursor.getString(3);

            listAlarm.add(new NotiFragment.Alarm(id, hour, minute, days));

            if( hour == currentHour && minute == currentMinute){
                String message = "?????n gi??? t???p th??i n??o!";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.ic_baseline_self_improvement_24)
                        .setContentTitle("Workout")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intent = new Intent(getContext(), HitDat.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);

                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, builder.build());
            }
            cursor.moveToNext();
        }
        cursor.close();

    }

    TimePickerDialog.OnTimeSetListener listenerUpdate = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hourUpdate = (hourOfDay + " : " + minute);
            lastSelectedHour = hourOfDay;
            lastSelectedMinute = minute;
        }
    };

    private void openTimePickerDialog() {
        if(lastSelectedHour == -1)  {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            lastSelectedHour = c.get(Calendar.HOUR_OF_DAY);
            lastSelectedMinute = c.get(Calendar.MINUTE);
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                2, listener,
                lastSelectedHour, lastSelectedMinute, is24HView);
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour = (hourOfDay + " : " + minute);
            lastSelectedHour = hourOfDay;
            lastSelectedMinute = minute;
            displayDateDialog();
        }
    };

    public void displayDateDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View date_dialog = inflater.inflate(R.layout.date_dialog, null);

        cb2 = (CheckBox) date_dialog.findViewById(R.id.cbMonday);
        cb3 = (CheckBox) date_dialog.findViewById(R.id.cbTuesday);
        cb4 = (CheckBox) date_dialog.findViewById(R.id.cbWednesday);
        cb5 = (CheckBox) date_dialog.findViewById(R.id.cbThursday);
        cb6 = (CheckBox) date_dialog.findViewById(R.id.cbFriday);
        cb7 = (CheckBox) date_dialog.findViewById(R.id.cbSaturday);
        cbCN = (CheckBox) date_dialog.findViewById(R.id.cbSunday);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext(), 2);
        alert.setTitle("L???p l???i");

        alert.setView(date_dialog);
        alert.setCancelable(false);

        alert.setNegativeButton("Tho??t", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.setPositiveButton("?????t", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dayChecked();
                Boolean checkInsertData = db.insertAlarm(lastSelectedHour, lastSelectedMinute, days);
                if(checkInsertData == true) {
                    Toast.makeText(getContext(), "???? th??m m???t b??o th???c", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Kh??ng th??m ???????c b??o th???c", Toast.LENGTH_SHORT).show();
                }

               loadAlarm();
                alarmListViewAdapter = new AlarmListViewAdapter(listAlarm);
                lv_alarm.setAdapter(alarmListViewAdapter);
                alarmListViewAdapter.notifyDataSetChanged();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();

    }

    void loadAlarm() {
        listAlarm.clear();

        Cursor cursor = db.getDataAlarm();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            int hour = cursor.getInt(1);
            int minute = cursor.getInt(2);
            String days = cursor.getString(3);

            listAlarm.add(new Alarm(id, hour, minute, days));

            cursor.moveToNext();
        }

        cursor.close();
    }


    void dayChecked() {
        days = null;
        if(cb2.isChecked()){
            days = cb2.getText().toString();
        }
        if(cb3.isChecked()){
            if(days == null) {
                days = cb3.getText().toString();
            }else {
                days += "," + cb3.getText().toString();
            }
        }
        if(cb4.isChecked()){
            if(days == null) {
                days = cb4.getText().toString();
            }else {
                days += "," + cb4.getText().toString();
            }
        }
        if(cb5.isChecked()){
            if(days == null) {
                days = cb5.getText().toString();
            }else {
                days += "," + cb5.getText().toString();
            }
        }
        if(cb6.isChecked()){
            if(days == null) {
                days = cb6.getText().toString();
            }else {
                days += "," + cb6.getText().toString();
            }
        }
        if(cb7.isChecked()){
            if(days == null) {
                days = cb7.getText().toString();
            }else {
                days += "," + cb7.getText().toString();
            }
        }
        if(cbCN.isChecked()){
            if(days == null) {
                days = cbCN.getText().toString();
            }else {
                days += "," + cbCN.getText().toString();
            }
        }
        if(cbCN.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()
                && cb5.isChecked() && cb6.isChecked() && cb7.isChecked()) {
            days = "H???ng ng??y";
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    public static class Alarm {
        int id;
        int hour;
        int minute;
        String days;


        public Alarm(int id, int hour, int minute, String days) {
            this.id = id;
            this.hour = hour;
            this.minute = minute;
            this.days = days;
        }

    }

    class AlarmListViewAdapter extends BaseAdapter {
        final ArrayList<Alarm> listAlarm;

        AlarmListViewAdapter(ArrayList<Alarm> listAlarm) {
            this.listAlarm = listAlarm;
        }

        @Override
        public int getCount() {
            //Tr??? v??? t???ng s??? ph???n t???, n?? ???????c g???i b???i ListView
            return listAlarm.size();
        }

        @Override
        public Object getItem(int position) {
            //Tr??? v??? d??? li???u ??? v??? tr?? position c???a Adapter, t????ng ???ng l?? ph???n t???
            //c?? ch??? s??? position trong listAlarm
            return listAlarm.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Tr??? v??? m???t ID c???a ph???n
            return listAlarm.get(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView l?? View c???a ph???n t??? ListView, n???u convertView != null ngh??a l??
            //View n??y ???????c s??? d???ng l???i, ch??? vi???c c???p nh???t n???i dung m???i
            //N???u null c???n t???o m???i

            View viewAlarm;
            if (convertView == null) {
                viewAlarm = View.inflate(parent.getContext(), R.layout.alarm_view, null);
            } else viewAlarm = convertView;

            //Bind d??? li???u ph???n t??? v??o View
            Alarm alarm = (Alarm) getItem(position);
            ((TextView) viewAlarm.findViewById(R.id.tv_hour_minute)).setText(String.format(alarm.hour + " : " + alarm.minute));
            ((TextView) viewAlarm.findViewById(R.id.tv_daysChecked)).setText(String.format("%s", alarm.days));

            return viewAlarm;
        }

    }
}