package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Notification;
import pro.sky.telegrambot.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final TelegramBot telegramBot;

    public NotificationService(NotificationRepository notificationRepository, TelegramBot telegramBot) {
        this.notificationRepository = notificationRepository;
        this.telegramBot = telegramBot;
    }

    public void sendNotifications(LocalDateTime dateTime) {
        List<Notification> tasks = notificationRepository.findAllByExecDate(dateTime);
        tasks.forEach(t -> {
            telegramBot.execute(new SendMessage(t.getChatId(), t.getText()));
        });
    }
}
