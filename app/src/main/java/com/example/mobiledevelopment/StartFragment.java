package com.example.mobiledevelopment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class StartFragment extends Fragment {
    public final String CHANNEL_ID = "Channel_ID";
    private final int notificationId = 10;
    public StartFragment() {
        super(R.layout.fragment_start);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("This is Channel 1");
            NotificationManager notificationManager = (NotificationManager)requireContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        view.findViewById(R.id.buttonToList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String info = "Данные, переданные из StartFragment в ListFragment";
                bundle.putString("listKey", info);
                Navigation.findNavController(v).navigate(R.id.startToList, bundle);
            }
        });
        view.findViewById(R.id.buttonToRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String info = "Данные, переданные из StartFragment в RecyclerFragment";
                bundle.putString("recyclerKey", info);
                Navigation.findNavController(v).navigate(R.id.startToRecycler, bundle);
            }
        });

        view.findViewById(R.id.buttonNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.baseline_ac_unit_24)
                        .setContentTitle("My Mobile App")
                        .setContentText("It's my first notification")
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission) != PackageManager.PERMISSION_GRANTED)
                    return;
                notificationManager.notify(notificationId, builder.build());

            }
        });

        return view;
    }
}

