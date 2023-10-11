package com.zenika.story.adventure.domain.model

import androidx.annotation.StringRes
import com.zenika.R

enum class AdventureHint(
    @StringRes
    val text: Int
) {
    PORTAL_HINT(R.string.portal_hint),
    AGENCY_SCAN_HINT(R.string.agency_scan_hint),
    ON_OFF_HINT(R.string.on_off_hint),
    SINGAPORE_AGENCY_HINT(R.string.singapore_agency_hint),
    CASABLANCA_OUTSIDE_HINT(R.string.casablanca_outside_hint),
    CASABLANCA_FLASHLIGHT_HINT(R.string.casablanca_flashlight_hint),
    CASABLANCA_CODE_HINT(R.string.casablanca_code_hint),
    CASABLANCA_SAFE_HINT(R.string.casablanca_safe_hint),
    SIMON_SAYS_HINT(R.string.simon_says_hint),
    MONTREAL_AGENCY_HINT(R.string.montreal_agency_hint),
    NO_HINT(R.string.no_hint)
}
