/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gnd.persistence.local.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

/** Data access object for database operations related to {@link RecordMutationEntity}. */
@Dao
public interface RecordMutationDao {
  @Insert
  Completable insert(RecordMutationEntity entity);

  @Query("DELETE FROM record_mutation WHERE id IN (:ids)")
  Completable deleteAll(List<Long> ids);

  @Query("SELECT * FROM record_mutation WHERE feature_id = :featureId")
  Single<List<RecordMutationEntity>> findByFeatureId(String featureId);

  @Query("SELECT * FROM record_mutation WHERE record_id = :recordId")
  Single<List<RecordMutationEntity>> findByRecordId(String recordId);
}
