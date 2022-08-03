package com.project.demo.preference.repository;

import com.project.demo.preference.entity.Preference;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}

