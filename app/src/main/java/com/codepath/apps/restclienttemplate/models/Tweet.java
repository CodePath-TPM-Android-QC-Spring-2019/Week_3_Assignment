package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


/*
 * This is a temporary, sample model that demonstrates the basic structure
 * of a SQLite persisted Model object. Check out the Room guide for more details:
 * https://github.com/codepath/android_guides/wiki/Room-Guide
 *
 */
@Entity
public class Tweet {

	@PrimaryKey(autoGenerate = true)
	public Long uid;

	// Define table fields
	@ColumnInfo
    public String createdAt;

	@Ignore
	public User user;
	public String body;

	public Tweet() {}

	// Parse model from JSON
	public static Tweet fromJson(JSONObject object) throws JSONException{
		Tweet tweet = new Tweet();
		tweet.body = object.getString("text");
		tweet.uid = object.getLong("id");
		tweet.createdAt = object.getString("created_at");
		tweet.user = User.fromJson(object.getJSONObject("user"));

		Log.d("_AF", "~~~~~~~~ " + tweet.user.screenName + ":  " + tweet.body);

		return tweet;
	}
}
