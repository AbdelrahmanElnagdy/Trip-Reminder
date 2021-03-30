package com.example.tripreminder.data.model.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TripRoomDatabase_Impl extends TripRoomDatabase {
  private volatile TripDao _tripDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `trip_table` (`tripe_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tripe_name` TEXT, `start_point` TEXT, `end_point` TEXT, `date` TEXT, `time` TEXT, `repeated` TEXT, `direction` INTEGER NOT NULL, `notes` TEXT, `status` TEXT, `user-email` TEXT, `work-manager-tag` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `note_table` (`note_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `note` TEXT, `tripe` INTEGER NOT NULL, `note_status` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '400edf68e8ac66a1c2d9762a47e6fa45')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `trip_table`");
        _db.execSQL("DROP TABLE IF EXISTS `note_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTripTable = new HashMap<String, TableInfo.Column>(12);
        _columnsTripTable.put("tripe_id", new TableInfo.Column("tripe_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("tripe_name", new TableInfo.Column("tripe_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("start_point", new TableInfo.Column("start_point", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("end_point", new TableInfo.Column("end_point", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("repeated", new TableInfo.Column("repeated", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("direction", new TableInfo.Column("direction", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("user-email", new TableInfo.Column("user-email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTripTable.put("work-manager-tag", new TableInfo.Column("work-manager-tag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTripTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTripTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTripTable = new TableInfo("trip_table", _columnsTripTable, _foreignKeysTripTable, _indicesTripTable);
        final TableInfo _existingTripTable = TableInfo.read(_db, "trip_table");
        if (! _infoTripTable.equals(_existingTripTable)) {
          return new RoomOpenHelper.ValidationResult(false, "trip_table(com.example.tripreminder.data.model.db.Trips).\n"
                  + " Expected:\n" + _infoTripTable + "\n"
                  + " Found:\n" + _existingTripTable);
        }
        final HashMap<String, TableInfo.Column> _columnsNoteTable = new HashMap<String, TableInfo.Column>(4);
        _columnsNoteTable.put("note_id", new TableInfo.Column("note_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("tripe", new TableInfo.Column("tripe", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("note_status", new TableInfo.Column("note_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNoteTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNoteTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNoteTable = new TableInfo("note_table", _columnsNoteTable, _foreignKeysNoteTable, _indicesNoteTable);
        final TableInfo _existingNoteTable = TableInfo.read(_db, "note_table");
        if (! _infoNoteTable.equals(_existingNoteTable)) {
          return new RoomOpenHelper.ValidationResult(false, "note_table(com.example.tripreminder.data.model.db.Notes).\n"
                  + " Expected:\n" + _infoNoteTable + "\n"
                  + " Found:\n" + _existingNoteTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "400edf68e8ac66a1c2d9762a47e6fa45", "e2a90271cd97553d481b81352f976ee4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "trip_table","note_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `trip_table`");
      _db.execSQL("DELETE FROM `note_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public TripDao tripDao() {
    if (_tripDao != null) {
      return _tripDao;
    } else {
      synchronized(this) {
        if(_tripDao == null) {
          _tripDao = new TripDao_Impl(this);
        }
        return _tripDao;
      }
    }
  }
}
