package com.project.demo.preference.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.subject.entity.Subject;

import java.util.List;

public interface PreferenceService {
    List<Preference> getPreferences();
}