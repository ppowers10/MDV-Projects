package com.ppdesdev.congress;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ppdesdev.lib.Files;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class NameProvider extends ContentProvider {

	public static final String AUTHORITY = "com.ppdesdev.congress.nameprovider";
	
	public static class LeaderData implements BaseColumns {
		
		public static Uri CONTENT_UIR = Uri.parse("content://" + AUTHORITY + "/names");
		
		public static String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ppdesdev.congress.item";
		public static String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ppdesdev.congress.item";
		
		//Define columns
		public static final String FIRST_COLUMN = "first";
		public static final String LAST_COLUMN = "last";
		
		public static final String[] PROJECTION = {"_Id", FIRST_COLUMN, LAST_COLUMN };
		
		private LeaderData() {};
		
	}
	
	public static final int ITEMS = 1;
	public static final int ITEMS_ID = 2;
	
	private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	static {
		uriMatcher.addURI(AUTHORITY, "items/", ITEMS);
		uriMatcher.addURI(AUTHORITY, "items/#", ITEMS_ID);
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		
		switch (uriMatcher.match(uri)){
			
		case ITEMS:
				return LeaderData.CONTENT_TYPE;
		
		case ITEMS_ID:
			return LeaderData.CONTENT_ITEM_TYPE;
		
		}
		
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		
		MatrixCursor result = new MatrixCursor(LeaderData.PROJECTION);
		
		String JSONString = Files.readStringFile(getContext(), "congressNames", true);
		JSONObject job = null;
		JSONArray leadersArray = null;
		JSONObject results = null;
		
		try {
			job = new JSONObject(JSONString);
			leadersArray = job.getJSONArray(ServiceUpdate.JSON_RESULTS);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (leadersArray == null){
			return result;
		}
		
		switch (uriMatcher.match(uri)){
		
		case ITEMS:
			for (int i = 0; i < leadersArray.length(); i++) {
				try {
					results = leadersArray.getJSONObject(i).getJSONObject(ServiceUpdate.JSON_RESULTS);
					result.addRow(new Object[] { i + 1, results.get(ServiceUpdate.JSON_FIRST), results.get(ServiceUpdate.JSON_LAST)});
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		case ITEMS_ID:
		
		}
		return result;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
