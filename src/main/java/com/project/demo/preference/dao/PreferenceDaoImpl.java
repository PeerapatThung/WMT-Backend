package com.project.demo.preference.dao;

import com.project.demo.preference.entity.Preference;
import com.project.demo.preference.repository.PreferenceRepository;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PreferenceDaoImpl implements PreferenceDao {
    @Autowired
    PreferenceRepository preferenceRepository;

    @Override
    public List<Preference> getPreferences() {
        return preferenceRepository.findAll();
    }
}
