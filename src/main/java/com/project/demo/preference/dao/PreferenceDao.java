package com.project.demo.preference.dao;

import com.project.demo.preference.entity.Preference;
import com.project.demo.subject.entity.Subject;

import java.util.List;

public interface PreferenceDao {
    List<Preference> getPreferences();
}
