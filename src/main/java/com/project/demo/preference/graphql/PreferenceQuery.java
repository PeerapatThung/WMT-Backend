package com.project.demo.preference.graphql;

import com.project.demo.preference.dto.PreferenceDTO;
import com.project.demo.preference.entity.Preference;
import com.project.demo.preference.service.PreferenceService;
import com.project.demo.subject.dto.SubjectDTO;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.service.SubjectService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PreferenceQuery implements GraphQLQueryResolver {
    @Autowired
    PreferenceService preferenceService;

    @Transactional
    public List<PreferenceDTO> getPreferences() {
        List<Preference> preferences = preferenceService.getPreferences();
        return WMTMapper.INSTANCE.getPreferencesDTO(preferences);
    }
}
