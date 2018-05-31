package demo.teamwork.aquidigital.messages;

/**
 * Injects dependencies in the Messages component
 */
public interface MessagesComponent {

    void inject(MessagesFragment fragment);

    void inject (MessagesPresenter presenter);

}
