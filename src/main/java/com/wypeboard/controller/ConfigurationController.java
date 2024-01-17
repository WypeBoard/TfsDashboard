package com.wypeboard.controller;

import com.wypeboard.controller.command.ConfigurationCommand;
import com.wypeboard.model.persistence.domain.Configuration;
import com.wypeboard.model.persistence.jpa.ConfigurationJpa;
import com.wypeboard.model.persistence.types.ConfigurationName;
import com.wypeboard.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.Optional;

@Controller
public class ConfigurationController extends BaseController {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    protected Page getPageDefinition() {
        return Page.CONFIGURATION;
    }

    @GetMapping(path = "/configuration")
    public String configurationView(Model model) {
        ConfigurationCommand configurationCommand = new ConfigurationCommand();
        Map<ConfigurationName, String> configuations = configurationRepository.getAllEntitiesByKeyValue();
        configurationCommand.setAccessToken(configuations.getOrDefault(ConfigurationName.ACCESS_TOKEN, null));
        configurationCommand.setAccessToken(configuations.getOrDefault(ConfigurationName.BASE_URL, null));
        configurationCommand.setAccessToken(configuations.getOrDefault(ConfigurationName.TARGET_BRANCH, null));
        model.addAttribute("command", configurationCommand);
        return finalizeModelSetup(model);
    }

    @PostMapping(path = "/configuration/commit")
    public String configurationCommit(@ModelAttribute("command") ConfigurationCommand command, Model model) {
        Map<ConfigurationName, Configuration> configuations = configurationRepository.getAllEntitiesByKeyFunction();
        commitChangeOnUpdate(configuations, command.getAccessToken(), ConfigurationName.ACCESS_TOKEN);
        commitChangeOnUpdate(configuations, command.getAccessToken(), ConfigurationName.BASE_URL);
        commitChangeOnUpdate(configuations, command.getAccessToken(), ConfigurationName.TARGET_BRANCH);
        return finalizeModelSetup(model);
    }

    private void commitChangeOnUpdate(Map<ConfigurationName, Configuration> configuations, String commandValue, ConfigurationName configurationName) {
        Optional<Configuration> optionalConfiguration = Optional.ofNullable(configuations.getOrDefault(configurationName, null));
        optionalConfiguration.filter(config -> !config.getValue().equals(commandValue)).ifPresent(config -> {
            config.setValue(commandValue);
            configurationRepository.persistEntity(config);
        });
    }
}
