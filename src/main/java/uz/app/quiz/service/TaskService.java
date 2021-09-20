/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 18.09.2021
Time: 14:33
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.app.quiz.entity.*;
import uz.app.quiz.entity.enums.FourSectionEnum;
import uz.app.quiz.entity.enums.ThreeSectionEnum;
import uz.app.quiz.exception.UserNotFoundException;
import uz.app.quiz.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProgressRepository userProgressRepository;

    @Autowired
    SpeakingTaskRepository speakingTaskRepository;

    @Autowired
    ReadingTaskRepository readingTaskRepository;

    @Autowired
    WritingTaskRepository writingTaskRepository;

    @Autowired
    ListeningTaskRepository listeningTaskRepository;

    @Autowired
    GlobalConstantRepository globalConstantRepository;

    public String setTask(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        GlobalConstant globalConstant = globalConstantRepository.findFirstByOrderByCreatedAtDesc().orElseThrow(NullPointerException::new);
        UserProgress userProgress = new UserProgress();
        userProgress.setUser(user);
        //set speaking
        Integer count = speakingTaskRepository.countAllByDifficultyLessThanOrderByCreatedAtDesc(globalConstant.getMaxHardness());
        userProgress.setSpeakingTask(speakingTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count)).orElseThrow(NullPointerException::new));

        //set reading
        List<ReadingTask> readingTasks = new ArrayList<>();
        count = readingTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), ThreeSectionEnum.FIRST_SECTION);
        readingTasks.add(readingTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), ThreeSectionEnum.FIRST_SECTION).orElseThrow(NullPointerException::new));

        count = readingTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), ThreeSectionEnum.SECOND_SECTION);
        readingTasks.add(readingTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), ThreeSectionEnum.SECOND_SECTION).orElseThrow(NullPointerException::new));

        count = readingTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), ThreeSectionEnum.THIRD_SECTION);
        readingTasks.add(readingTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), ThreeSectionEnum.THIRD_SECTION).orElseThrow(NullPointerException::new));

        userProgress.setReadingTask(readingTasks);
        //set reading
        List<ListeningTask> listeningTasks = new ArrayList<>();
        count = listeningTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), FourSectionEnum.FIRST_SECTION);
        listeningTasks.add(listeningTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), FourSectionEnum.FIRST_SECTION).orElseThrow(NullPointerException::new));

        count = listeningTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), FourSectionEnum.SECOND_SECTION);
        listeningTasks.add(listeningTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), FourSectionEnum.SECOND_SECTION).orElseThrow(NullPointerException::new));

        count = listeningTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), FourSectionEnum.THIRD_SECTION);
        listeningTasks.add(listeningTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), FourSectionEnum.THIRD_SECTION).orElseThrow(NullPointerException::new));

        count = listeningTaskRepository.countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(globalConstant.getMaxHardness(), FourSectionEnum.FOURTH_SECTION);
        listeningTasks.add(listeningTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count), FourSectionEnum.FOURTH_SECTION).orElseThrow(NullPointerException::new));

        userProgress.setListeningTasks(listeningTasks);

        //add writing task

        count = writingTaskRepository.countAllByDifficultyLessThanOrderByCreatedAtDesc(globalConstant.getMaxHardness());

        userProgress.setWritingTask(writingTaskRepository.findBydifficlty(globalConstant.getMaxHardness(), new Random().nextInt(count)).orElseThrow(NullPointerException::new));

        userProgress = userProgressRepository.save(userProgress);
        user.setCurrentProgres(userProgress);
        userRepository.save(user);
        return "userga test biriktirildi!!!";
    }

}
