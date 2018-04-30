package com.eurezzolve.eucorretor.activities.secundarias;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.eurezzolve.eucorretor.helper.NotificationUtil;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;

public class NotificacaoActivity extends AppCompatActivity {

    private Switch swTabelas, swEmp, swAlertas,swLembretes;
    private static final String CHANNEL_ID = "idDoCanal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Notificações");

        /*Cria o channel necessario para o Android 8*/
        NotificationUtil.createChannel(this);

        swAlertas = findViewById(R.id.sw_alertas);
        swEmp = findViewById(R.id.sw_emp);
        swTabelas = findViewById(R.id.sw_tabelas);
        swLembretes = findViewById(R.id.sw_lembretes);

        swAlertas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    ativaAlertas();
                    Toast.makeText(getApplicationContext(), "Alertas ativados!", Toast.LENGTH_SHORT).show();
                } else{
                    desativaAlertas();
                    Toast.makeText(getApplicationContext(), "Alertas desativados!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swEmp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    ativaEmp();
                    Toast.makeText(getApplicationContext(), "Alertas de Empreendimentos ativado!", Toast.LENGTH_SHORT).show();
                } else {
                    desativaEmp();
                    Toast.makeText(getApplicationContext(), "Alertas de Empreendimentos desativado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swTabelas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    ativaTabela();
                    Toast.makeText(getApplicationContext(), "Alertas de Tabelas ativado!", Toast.LENGTH_SHORT).show();
                } else {
                    desativaTabela();
                    Toast.makeText(getApplicationContext(), "Alertas de Tabelas desativado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swLembretes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    //ativaAlertasLembrete();
                } else {
                    //desativaAlertasLembrete();
                }
            }
        });
    }

    /*Ativa e desativa os lembretes diarios*/
    public void ativaAlertasLembrete(){

    }

    //Desativa e ativa do Topico tabelas
    public void desativaTabela(){
        FirebaseMessaging.getInstance().unsubscribeFromTopic("tabelas");
    }

    public void ativaTabela(){
        FirebaseMessaging.getInstance().subscribeToTopic("tabelas");
    }

    //Desativa e ativa do Topico de Empreendimentos
    public void desativaEmp(){
        FirebaseMessaging.getInstance().unsubscribeFromTopic("emp");
    }

    public void ativaEmp(){
        FirebaseMessaging.getInstance().subscribeToTopic("emp");
    }

    //Desativa e ativa do Topico de Empreendimentos
    public void desativaAlertas(){
        FirebaseMessaging.getInstance().unsubscribeFromTopic("alertas");
    }

    public void ativaAlertas(){
        FirebaseMessaging.getInstance().subscribeToTopic("alertas");
    }

    /*public long getTime(){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis();
    }*/

    public void criarNotificacao(){
        long[] padrao = {150,300,150,300};

        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification_alert)
                .setContentTitle("EuCorretor")
                .setContentText("Acesse hoje o aplicativo!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setVibrate(padrao)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(R.drawable.ic_notification_alert,mBuilder.build());
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
