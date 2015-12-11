package com.loveplusplus.demo.image;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends ListActivity {

	public static final String TAG = "MainActivity";
	private MyListAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new MyTask().execute();

	}

	class MyTask extends AsyncTask<Void, Void, MyMessage> {

		@Override
		protected MyMessage doInBackground(Void... params) {
			String json = "{\"code\":200,\"msg\":\"ok\",list:["
					+ "{\"id\":110,\"avator\":\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"name\":\"张三\",\"content\":\"大家好\",\"urls\":[]},"
					+ "{\"id\":111,\"avator\":\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"name\":\"李四\",\"content\":\"大家好\",\"urls\":[\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\"]},"
					+ "{\"id\":112,\"avator\":\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"name\":\"王五\",\"content\":\"大家好\",\"urls\":[\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\"]},"
					+ "{\"id\":113,\"avator\":\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"name\":\"赵六\",\"content\":\"大家好\",\"urls\":[\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\",\"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg\"]}]}";
			Gson gson = new Gson();
			MyMessage msg = gson.fromJson(json, MyMessage.class);
			return msg;
		}

		@Override
		protected void onPostExecute(MyMessage result) {
			mAdapter = new MyListAdapter(MainActivity.this, result.list);
			setListAdapter(mAdapter);

		}

	}
}
