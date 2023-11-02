package pro.sky.telegrambot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "notification_task")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatId;

    private String text;

    private LocalDateTime execDate;

    public Notification() {
    }

    public Notification(Long chatId, String text, LocalDateTime execDate) {
        this.chatId = chatId;
        this.text = text;
        this.execDate = execDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getExecDate() {
        return execDate;
    }

    public void setExecDate(LocalDateTime execDate) {
        this.execDate = execDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getChatId(), that.getChatId()) && Objects.equals(getText(), that.getText()) && Objects.equals(getExecDate(), that.getExecDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChatId(), getText(), getExecDate());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", text='" + text + '\'' +
                ", execDate=" + execDate +
                '}';
    }
}
