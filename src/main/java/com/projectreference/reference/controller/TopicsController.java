package com.projectreference.reference.controller;

import com.projectreference.reference.TopicsService.TopicService;
import com.projectreference.reference.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicsController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {

        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable("id") String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopicService(topic);

    }

    @RequestMapping(value = "/topics",method = RequestMethod.PUT)
    public void updateTopics(@RequestBody Topic topic){
        topicService.upDateTopic(topic);
    }

    @RequestMapping(value = "/topics",method = RequestMethod.DELETE)
    public void deleteTopics(@RequestBody Topic topic){
            topicService.deleteTopic(topic);
    }
}
