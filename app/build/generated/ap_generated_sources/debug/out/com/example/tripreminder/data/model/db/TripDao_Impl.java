package com.example.tripreminder.data.model.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TripDao_Impl implements TripDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Trips> __insertionAdapterOfTrips;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTripStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTrip;

  private final SharedSQLiteStatement __preparedStmtOfSetNote;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTrip;

  public TripDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrips = new EntityInsertionAdapter<Trips>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `trip_table` (`tripe_id`,`tripe_name`,`start_point`,`end_point`,`date`,`time`,`repeated`,`direction`,`notes`,`status`,`user-email`,`work-manager-tag`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trips value) {
        stmt.bindLong(1, value.getTripId());
        if (value.getTripName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTripName());
        }
        if (value.getStartPoint() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStartPoint());
        }
        if (value.getEndPoint() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEndPoint());
        }
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
        if (value.getTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTime());
        }
        if (value.getRepeated() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRepeated());
        }
        final int _tmp;
        _tmp = value.isDirection() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        final String _tmp_1;
        _tmp_1 = Converters.myObjectsToStoredString(value.getNotes());
        if (_tmp_1 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, _tmp_1);
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getUserEmail() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUserEmail());
        }
        if (value.getWorkManagerTag() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getWorkManagerTag());
        }
      }
    };
    this.__preparedStmtOfUpdateTripStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE trip_table SET status = ? WHERE tripe_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTrip = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE trip_table SET tripe_name= ?,start_point= ?, end_point= ?, date= ?,time= ?,repeated= ?,direction= ?,`work-manager-tag`= ? WHERE tripe_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetNote = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE trip_table SET notes = ? WHERE tripe_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTrip = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM trip_table WHERE tripe_id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insertTrip(final Trips trips) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTrips.insertAndReturnId(trips);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTripStatus(final String status, final int tripId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTripStatus.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, tripId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTripStatus.release(_stmt);
    }
  }

  @Override
  public void updateTrip(final String tripName, final String startPoint, final String endPoint,
      final String date, final String time, final String repeated, final boolean direction,
      final String workManagerTag, final int tripId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTrip.acquire();
    int _argIndex = 1;
    if (tripName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, tripName);
    }
    _argIndex = 2;
    if (startPoint == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, startPoint);
    }
    _argIndex = 3;
    if (endPoint == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, endPoint);
    }
    _argIndex = 4;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 5;
    if (time == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, time);
    }
    _argIndex = 6;
    if (repeated == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, repeated);
    }
    _argIndex = 7;
    final int _tmp;
    _tmp = direction ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 8;
    if (workManagerTag == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, workManagerTag);
    }
    _argIndex = 9;
    _stmt.bindLong(_argIndex, tripId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTrip.release(_stmt);
    }
  }

  @Override
  public void setNote(final List<Note> note, final int tripId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetNote.acquire();
    int _argIndex = 1;
    final String _tmp;
    _tmp = Converters.myObjectsToStoredString(note);
    if (_tmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, tripId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetNote.release(_stmt);
    }
  }

  @Override
  public void deleteTrip(final int tripTd) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTrip.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, tripTd);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTrip.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Trips>> getUpComingTrips(final String userEmail) {
    final String _sql = "SELECT * FROM trip_table WHERE status = 'upComing' AND `user-email` = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userEmail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userEmail);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<List<Trips>>() {
      @Override
      public List<Trips> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTripId = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_id");
          final int _cursorIndexOfTripName = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_name");
          final int _cursorIndexOfStartPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "start_point");
          final int _cursorIndexOfEndPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "end_point");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfRepeated = CursorUtil.getColumnIndexOrThrow(_cursor, "repeated");
          final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user-email");
          final int _cursorIndexOfWorkManagerTag = CursorUtil.getColumnIndexOrThrow(_cursor, "work-manager-tag");
          final List<Trips> _result = new ArrayList<Trips>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Trips _item;
            _item = new Trips();
            final int _tmpTripId;
            _tmpTripId = _cursor.getInt(_cursorIndexOfTripId);
            _item.setTripId(_tmpTripId);
            final String _tmpTripName;
            _tmpTripName = _cursor.getString(_cursorIndexOfTripName);
            _item.setTripName(_tmpTripName);
            final String _tmpStartPoint;
            _tmpStartPoint = _cursor.getString(_cursorIndexOfStartPoint);
            _item.setStartPoint(_tmpStartPoint);
            final String _tmpEndPoint;
            _tmpEndPoint = _cursor.getString(_cursorIndexOfEndPoint);
            _item.setEndPoint(_tmpEndPoint);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpTime;
            _tmpTime = _cursor.getString(_cursorIndexOfTime);
            _item.setTime(_tmpTime);
            final String _tmpRepeated;
            _tmpRepeated = _cursor.getString(_cursorIndexOfRepeated);
            _item.setRepeated(_tmpRepeated);
            final boolean _tmpDirection;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDirection);
            _tmpDirection = _tmp != 0;
            _item.setDirection(_tmpDirection);
            final List<Note> _tmpNotes;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfNotes);
            _tmpNotes = Converters.storedStringToMyObjects(_tmp_1);
            _item.setNotes(_tmpNotes);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUserEmail;
            _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            _item.setUserEmail(_tmpUserEmail);
            final String _tmpWorkManagerTag;
            _tmpWorkManagerTag = _cursor.getString(_cursorIndexOfWorkManagerTag);
            _item.setWorkManagerTag(_tmpWorkManagerTag);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Trips>> getHistoryTrips(final String userEmail) {
    final String _sql = "SELECT * FROM trip_table WHERE status NOT LIKE '%upComing%' AND status NOT LIKE '%delete%' AND  `user-email` = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userEmail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userEmail);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<List<Trips>>() {
      @Override
      public List<Trips> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTripId = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_id");
          final int _cursorIndexOfTripName = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_name");
          final int _cursorIndexOfStartPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "start_point");
          final int _cursorIndexOfEndPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "end_point");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfRepeated = CursorUtil.getColumnIndexOrThrow(_cursor, "repeated");
          final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user-email");
          final int _cursorIndexOfWorkManagerTag = CursorUtil.getColumnIndexOrThrow(_cursor, "work-manager-tag");
          final List<Trips> _result = new ArrayList<Trips>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Trips _item;
            _item = new Trips();
            final int _tmpTripId;
            _tmpTripId = _cursor.getInt(_cursorIndexOfTripId);
            _item.setTripId(_tmpTripId);
            final String _tmpTripName;
            _tmpTripName = _cursor.getString(_cursorIndexOfTripName);
            _item.setTripName(_tmpTripName);
            final String _tmpStartPoint;
            _tmpStartPoint = _cursor.getString(_cursorIndexOfStartPoint);
            _item.setStartPoint(_tmpStartPoint);
            final String _tmpEndPoint;
            _tmpEndPoint = _cursor.getString(_cursorIndexOfEndPoint);
            _item.setEndPoint(_tmpEndPoint);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpTime;
            _tmpTime = _cursor.getString(_cursorIndexOfTime);
            _item.setTime(_tmpTime);
            final String _tmpRepeated;
            _tmpRepeated = _cursor.getString(_cursorIndexOfRepeated);
            _item.setRepeated(_tmpRepeated);
            final boolean _tmpDirection;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDirection);
            _tmpDirection = _tmp != 0;
            _item.setDirection(_tmpDirection);
            final List<Note> _tmpNotes;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfNotes);
            _tmpNotes = Converters.storedStringToMyObjects(_tmp_1);
            _item.setNotes(_tmpNotes);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUserEmail;
            _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            _item.setUserEmail(_tmpUserEmail);
            final String _tmpWorkManagerTag;
            _tmpWorkManagerTag = _cursor.getString(_cursorIndexOfWorkManagerTag);
            _item.setWorkManagerTag(_tmpWorkManagerTag);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Trips>> getTrips(final String userEmail) {
    final String _sql = "SELECT * FROM trip_table WHERE status NOT LIKE '%delete%' AND  `user-email` = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userEmail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userEmail);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<List<Trips>>() {
      @Override
      public List<Trips> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTripId = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_id");
          final int _cursorIndexOfTripName = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_name");
          final int _cursorIndexOfStartPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "start_point");
          final int _cursorIndexOfEndPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "end_point");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfRepeated = CursorUtil.getColumnIndexOrThrow(_cursor, "repeated");
          final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user-email");
          final int _cursorIndexOfWorkManagerTag = CursorUtil.getColumnIndexOrThrow(_cursor, "work-manager-tag");
          final List<Trips> _result = new ArrayList<Trips>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Trips _item;
            _item = new Trips();
            final int _tmpTripId;
            _tmpTripId = _cursor.getInt(_cursorIndexOfTripId);
            _item.setTripId(_tmpTripId);
            final String _tmpTripName;
            _tmpTripName = _cursor.getString(_cursorIndexOfTripName);
            _item.setTripName(_tmpTripName);
            final String _tmpStartPoint;
            _tmpStartPoint = _cursor.getString(_cursorIndexOfStartPoint);
            _item.setStartPoint(_tmpStartPoint);
            final String _tmpEndPoint;
            _tmpEndPoint = _cursor.getString(_cursorIndexOfEndPoint);
            _item.setEndPoint(_tmpEndPoint);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpTime;
            _tmpTime = _cursor.getString(_cursorIndexOfTime);
            _item.setTime(_tmpTime);
            final String _tmpRepeated;
            _tmpRepeated = _cursor.getString(_cursorIndexOfRepeated);
            _item.setRepeated(_tmpRepeated);
            final boolean _tmpDirection;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDirection);
            _tmpDirection = _tmp != 0;
            _item.setDirection(_tmpDirection);
            final List<Note> _tmpNotes;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfNotes);
            _tmpNotes = Converters.storedStringToMyObjects(_tmp_1);
            _item.setNotes(_tmpNotes);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUserEmail;
            _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            _item.setUserEmail(_tmpUserEmail);
            final String _tmpWorkManagerTag;
            _tmpWorkManagerTag = _cursor.getString(_cursorIndexOfWorkManagerTag);
            _item.setWorkManagerTag(_tmpWorkManagerTag);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Trips> getTripById(final int tripId) {
    final String _sql = "SELECT * FROM trip_table WHERE tripe_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tripId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<Trips>() {
      @Override
      public Trips call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTripId = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_id");
          final int _cursorIndexOfTripName = CursorUtil.getColumnIndexOrThrow(_cursor, "tripe_name");
          final int _cursorIndexOfStartPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "start_point");
          final int _cursorIndexOfEndPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "end_point");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfRepeated = CursorUtil.getColumnIndexOrThrow(_cursor, "repeated");
          final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user-email");
          final int _cursorIndexOfWorkManagerTag = CursorUtil.getColumnIndexOrThrow(_cursor, "work-manager-tag");
          final Trips _result;
          if(_cursor.moveToFirst()) {
            _result = new Trips();
            final int _tmpTripId;
            _tmpTripId = _cursor.getInt(_cursorIndexOfTripId);
            _result.setTripId(_tmpTripId);
            final String _tmpTripName;
            _tmpTripName = _cursor.getString(_cursorIndexOfTripName);
            _result.setTripName(_tmpTripName);
            final String _tmpStartPoint;
            _tmpStartPoint = _cursor.getString(_cursorIndexOfStartPoint);
            _result.setStartPoint(_tmpStartPoint);
            final String _tmpEndPoint;
            _tmpEndPoint = _cursor.getString(_cursorIndexOfEndPoint);
            _result.setEndPoint(_tmpEndPoint);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _result.setDate(_tmpDate);
            final String _tmpTime;
            _tmpTime = _cursor.getString(_cursorIndexOfTime);
            _result.setTime(_tmpTime);
            final String _tmpRepeated;
            _tmpRepeated = _cursor.getString(_cursorIndexOfRepeated);
            _result.setRepeated(_tmpRepeated);
            final boolean _tmpDirection;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDirection);
            _tmpDirection = _tmp != 0;
            _result.setDirection(_tmpDirection);
            final List<Note> _tmpNotes;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfNotes);
            _tmpNotes = Converters.storedStringToMyObjects(_tmp_1);
            _result.setNotes(_tmpNotes);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _result.setStatus(_tmpStatus);
            final String _tmpUserEmail;
            _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            _result.setUserEmail(_tmpUserEmail);
            final String _tmpWorkManagerTag;
            _tmpWorkManagerTag = _cursor.getString(_cursorIndexOfWorkManagerTag);
            _result.setWorkManagerTag(_tmpWorkManagerTag);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Note>> getNotes(final int triId) {
    final String _sql = "SELECT notes FROM trip_table WHERE tripe_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, triId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<List<Note>>() {
      @Override
      public List<Note> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Note> _result = new ArrayList<Note>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Note _item;
            _item = new Note();
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item.setNotes(_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getWorkManagerTag(final String userEmail, final int tripTd) {
    final String _sql = "SELECT `work-manager-tag` FROM trip_table  WHERE `user-email`=? AND tripe_id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userEmail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userEmail);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, tripTd);
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            _result = _cursor.getString(0);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTripId() {
    final String _sql = "SELECT tripe_id FROM trip_table ORDER BY tripe_id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"trip_table"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
