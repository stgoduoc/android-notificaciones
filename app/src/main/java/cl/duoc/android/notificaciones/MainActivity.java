package cl.duoc.android.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificar(View view) {
        // NotificationManager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Intent con Activity donde irá la app al pinchar la notificación
        Intent notificationIntent = new Intent(this, NotificacionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        // Builder de la Notificación
        android.support.v4.app.NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Mi Notificación")
                .setContentText("Mi texto de la notificación")
                .setContentIntent(pendingIntent);

        notificationManager.notify(1, notificationBuilder.build());

    }

    private void bak(View view) {
        String notificationService = Context.NOTIFICATION_SERVICE;

        NotificationManager notificationManager = (NotificationManager) getSystemService(notificationService);

        Intent notificationIntent = new Intent(this, NotificacionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        int icono = android.R.drawable.stat_sys_warning;
        Notification notification = new Notification(icono, "Mi notificación", System.currentTimeMillis());

        // id notificación, único en la app
        notificationManager.notify(1, notification);

        Toast.makeText(this, "Toast!!!!", Toast.LENGTH_SHORT).show();
    }
}
