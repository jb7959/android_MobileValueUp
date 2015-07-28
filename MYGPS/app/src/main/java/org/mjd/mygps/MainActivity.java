package org.mjd.mygps;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Iterator;
import java.util.List;


/**
 * 위치 관리자를 이용해 내 위치를 확인하는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 *
 */
public class MainActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_ANOTHER = 1001;
    GoogleMap map;
    RestaurantModel ResModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Map 초기화
        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        //레스토랑 모델 할당
        ResModel = new RestaurantModel();
        //버튼배열 5개 선언 및 할당
        Button [] buttons = new Button[]{
                (Button) findViewById(R.id.button01)
                ,(Button) findViewById(R.id.button02)
                ,(Button) findViewById(R.id.button03)
                ,(Button) findViewById(R.id.button04)
                ,(Button) findViewById(R.id.button05)
        };

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                // Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RestourantActivity.class);
                intent.putExtra("title", "송백식당"); // 인텐트에 데이터 추가.
                intent.putExtra("key", "1");
                startActivity(intent);
            }
        });

        // 버튼 이벤트 처리
            buttons[1].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // 위치 정보 확인을 위해 정의한 메소드 호출
                    //startLocationService();
                    List ResList;
                    Iterator iterator;
                    map.clear();
                        ResList = ResModel.getNW();
                        iterator = ResList.iterator();
                        while(iterator.hasNext()){
                            Restaurant res = (Restaurant)iterator.next();
                            Double latitude = res.getLatitude();
                            Double longitude = res.getLongitude();
                            String title = res.gettitle();
                            String phoneNumber = res.getPhoneNumber();
                            showMark(latitude, longitude, title, phoneNumber); //여기서부터 식당정보가 넘어가야함. 위치 포인트 찍기.
                            //마커클릭시이벤트
                        };
                        showLocation(37.5130529,126.9380114);

                }
            });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 위치 정보 확인을 위해 정의한 메소드 호출
                //startLocationService();
                List ResList;
                Iterator iterator;
                map.clear();
                ResList = ResModel.getNE();
                iterator = ResList.iterator();
                while (iterator.hasNext()) {
                    Restaurant res = (Restaurant) iterator.next();
                    Double latitude = res.getLatitude();
                    Double longitude = res.getLongitude();
                    String title = res.gettitle();
                    String phoneNumber = res.getPhoneNumber();
                    showMark(latitude, longitude, title, phoneNumber); //여기서부터 식당정보가 넘어가야함. 위치 포인트 찍기.
                    //마커클릭시이벤트
                };
                showLocation(37.5119953, 126.9440458);

            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 위치 정보 확인을 위해 정의한 메소드 호출
                //startLocationService();
                List ResList;
                Iterator iterator;
                map.clear();
                ResList = ResModel.getSW();
                iterator = ResList.iterator();
                while (iterator.hasNext()) {
                    Restaurant res = (Restaurant) iterator.next();
                    Double latitude = res.getLatitude();
                    Double longitude = res.getLongitude();
                    String title = res.gettitle();
                    String phoneNumber = res.getPhoneNumber();
                    showMark(latitude, longitude, title, phoneNumber); //여기서부터 식당정보가 넘어가야함. 위치 포인트 찍기.
                    //마커클릭시이벤트
                };
                showLocation(37.5069320,126.9396987);
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 위치 정보 확인을 위해 정의한 메소드 호출
                //startLocationService();
                List ResList;
                Iterator iterator;
                map.clear();
                ResList = ResModel.getSE();
                iterator = ResList.iterator();
                while (iterator.hasNext()) {
                    Restaurant res = (Restaurant) iterator.next();
                    Double latitude = res.getLatitude();
                    Double longitude = res.getLongitude();
                    String title = res.gettitle();
                    String phoneNumber = res.getPhoneNumber();
                    showMark(latitude, longitude, title, phoneNumber); //여기서부터 식당정보가 넘어가야함. 위치 포인트 찍기.
                    //마커클릭시이벤트
                };
                showLocation(37.5079397,126.9477678);

            }
        });

        buttons[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 위치 정보 확인을 위해 정의한 메소드 호출
                //startLocationService();
                List ResList;
                Iterator iterator;
                List [] resListArray = new List[]{ResModel.getNE(),ResModel.getNW(),ResModel.getSE(),ResModel.getSW()};
                for (int i = 0;i<resListArray.length;i++){
                    ResList = resListArray[i];
                    iterator = ResList.iterator();
                   while (iterator.hasNext()) {
                        Restaurant res = (Restaurant) iterator.next();
                        Double latitude = res.getLatitude();
                        Double longitude = res.getLongitude();
                        String title = res.gettitle();
                        String phoneNumber = res.getPhoneNumber();
                        showMark(latitude, longitude, title, phoneNumber); //여기서부터 식당정보가 넘어가야함. 위치 포인트 찍기.
                        //마커클릭시이벤트
                    };
                    showLocation(37.5088411, 126.940468);
                }
            }

        });
        }


    /**
     * 위치 정보 확인을 위해 정의한 메소드
     */
    private void startLocationService() {
        // 위치 관리자 객체 참조
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // 위치 정보를 받을 리스너 생성
        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        // GPS를 이용한 위치 요청
        manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime,
                minDistance,
                gpsListener);

        // 네트워크를 이용한 위치 요청
        manager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                minTime,
                minDistance,
                gpsListener);

        // 위치 확인이 안되는 경우에도 최근에 확인된 위치 정보 먼저 확인
        try {
            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                Double latitude = lastLocation.getLatitude();
                Double longitude = lastLocation.getLongitude();

                //Toast.makeText(getApplicationContext(), "Last Known Location : " + "Latitude : " + latitude + "\nLongitude:" + longitude, Toast.LENGTH_LONG).show();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "위치 확인이 시작되었습니다. 로그를 확인하세요.", Toast.LENGTH_SHORT).show();

    }


    /**
     * 리스너 클래스 정의
     */
    private class GPSListener implements LocationListener {
        /**
         * 위치 정보가 확인될 때 자동 호출되는 메소드
         */
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
            Log.i("GPSListener", msg);
            showCurrentLocation(latitude, longitude);

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        private void showCurrentLocation(Double latitude, Double longitude){
            LatLng curPoint = new LatLng(latitude, longitude); // 기준위치정보
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 19));
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

    }
    //맵에 초점 이동
    private void showLocation(Double latitude, Double longitude){
        //showMark(latitude,longitude,title,phoneNumber); //여기서 하이퍼링크 또는 상세정보 액티비티로 연결하는 방법 찾음 ; map.setOnInfoWindowClickListener
        LatLng curPoint = new LatLng(latitude, longitude); // 기준위치정보
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }


    //맵에 표시
    private void showMark(Double latitude, Double longitude,String title,String phoneNumber){
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(latitude + 0.000001, longitude + 0.000001));
        marker.title(title);
        marker.snippet(phoneNumber);
        marker.draggable(true);
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.rc));


        map.addMarker(marker);

    }

    @Override
    public void onResume() {
        super.onResume();

        // 내 위치 자동 표시 enable
        map.setMyLocationEnabled(true);

    }

    @Override
    public void onPause() {
        super.onPause();

        // 내 위치 자동 표시 disable
        map.setMyLocationEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop fisrst main",Toast.LENGTH_LONG).show();
    }
}
