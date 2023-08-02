// Generated by Dagger (https://dagger.dev).
package com.zenika.adventure.presentation.casablanca.meeting_room;

import com.zenika.adventure.domain.ObserveRemainingTimeUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MeetingRoomViewModel_Factory implements Factory<CasablancaMeetingRoomViewModel> {
  private final Provider<ObserveRemainingTimeUseCase> observeRemainingTimeProvider;

  public MeetingRoomViewModel_Factory(
      Provider<ObserveRemainingTimeUseCase> observeRemainingTimeProvider) {
    this.observeRemainingTimeProvider = observeRemainingTimeProvider;
  }

  @Override
  public CasablancaMeetingRoomViewModel get() {
    return newInstance(observeRemainingTimeProvider.get());
  }

  public static MeetingRoomViewModel_Factory create(
      Provider<ObserveRemainingTimeUseCase> observeRemainingTimeProvider) {
    return new MeetingRoomViewModel_Factory(observeRemainingTimeProvider);
  }

  public static CasablancaMeetingRoomViewModel newInstance(ObserveRemainingTimeUseCase observeRemainingTime) {
    return new CasablancaMeetingRoomViewModel(observeRemainingTime);
  }
}
