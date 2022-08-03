package com.project.demo.preference.service;

import com.project.demo.preference.dao.PreferenceDao;
import com.project.demo.preference.entity.Preference;
import com.project.demo.subject.dao.SubjectDao;
import com.project.demo.subject.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    @Autowired
    PreferenceDao preferenceDao;
    @Override
    public List<Preference> getPreferences() {
        return preferenceDao.getPreferences();
    }
}
