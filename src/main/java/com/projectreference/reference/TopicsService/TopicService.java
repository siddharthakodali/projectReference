package com.projectreference.reference.TopicsService;

import com.projectreference.reference.Repository.TopicsRepository;
import com.projectreference.reference.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    @Autowired
    TopicsRepository topicsRepository;

   /* List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring FrameWork", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("JavaScript", "JavaScript", "javascript Description ")
    ));*/

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicsRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        /*return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();*/
        return topicsRepository.findById(id);
    }

    public void addTopicService(Topic topic) {
        //topics.add(topic);
        topicsRepository.save(topic);
    }

    public void upDateTopic(Topic topic) {

       /* for (Topic topic1 : topics) {
            if (topic1.getId().equals(topic.getId())) {
                topics.set(topics.indexOf(topic1), topic);
            }
        }*/
       topicsRepository.save(topic);
    }

    public void deleteTopic(Topic topic) {

        //topics.removeIf(t -> t.getId().equals(topic.getId()));
        topicsRepository.delete(topic);

    }
}
