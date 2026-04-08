package project.mohak.booking.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import project.mohak.booking.platform.controller.*;
import project.mohak.booking.platform.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        // Document link : https://docs.google.com/document/d/1LXNpt_mw1BB9LH8FYG4E1wOpFQt0QmLSRuBxG6mva-k/edit?usp=sharing

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserController userController = context.getBean(UserController.class);
        TheatreController theatreController = context.getBean(TheatreController.class);
        MovieController movieController = context.getBean(MovieController.class);
        ShowController showController = context.getBean(ShowController.class);
        BookingController bookingController = context.getBean(BookingController.class);

        System.out.println("Application running now");

        userController.createUser("U1", "User1");
        userController.createUser("U2", "User2");

        movieController.createMovie("M1", "Movie1");
        movieController.createMovie("M2", "Movie2");

        theatreController.createTheatre("T1", "Theatre1", "A");
        theatreController.createTheatre("T2", "Theatre2", "A");

        theatreController.createScreenInTheatre("S1", "Screen1",
                "M1", "T1");
        theatreController.createScreenInTheatre("S2", "Screen2",
                "M1", "T1");

        theatreController.createScreenInTheatre("S3", "Screen1",
                "M1", "T2");
        theatreController.createScreenInTheatre("S4", "Screen2",
                "M1", "T2");



        // T1 S1
        theatreController.createSeatInScreen("T1", "S1", "A1", "A", "1");
        theatreController.createSeatInScreen("T1", "S1", "A2", "A", "2");
        theatreController.createSeatInScreen("T1", "S1", "B1", "B", "1");
        theatreController.createSeatInScreen("T1", "S1", "B2", "B", "2");

        // T1 S2
        theatreController.createSeatInScreen("T1", "S2", "A1", "A", "1");
        theatreController.createSeatInScreen("T1", "S2", "A2", "A", "2");
        theatreController.createSeatInScreen("T1", "S2", "B1", "B", "1");
        theatreController.createSeatInScreen("T1", "S2", "B2", "B", "2");

        // T2 S1
        theatreController.createSeatInScreen("T2", "S3", "A1", "A", "1");
        theatreController.createSeatInScreen("T2", "S3", "A2", "A", "2");
        theatreController.createSeatInScreen("T2", "S3", "B1", "B", "1");
        theatreController.createSeatInScreen("T2", "S3", "B2", "B", "2");

        // T2 S2
        theatreController.createSeatInScreen("T2", "S4", "A1", "A", "1");
        theatreController.createSeatInScreen("T2", "S4", "A2", "A", "2");
        theatreController.createSeatInScreen("T2", "S4", "B1", "B", "1");
        theatreController.createSeatInScreen("T2", "S4", "B2", "B", "2");

        // All users :
        List<User> users = userController.getAllUsers();
        System.out.println("All Users : ");
        for (User user : users)
            System.out.println(user.getName());

        // All movies :
        List<Movie> movies = movieController.getAllMovies();
        System.out.println("All Movies : ");
        for (Movie movie : movies)
            System.out.println(movie.getName());

        System.out.println("Get User name U1 : " + userController.getUser("U1").getName());
        System.out.println("Get Movie name M1 : " + movieController.getMovie("M1").getName());
        System.out.println("Get Theatre name T1 : " + theatreController.getTheatre("T1").getName());

        // T1 screens
        System.out.println("Get Theatre screens name T1 : ");
        List<Screen> screens = theatreController.getTheatre("T1").getScreens();
        for (Screen screen : screens)
            System.out.println(screen.getName());

        // T1 S1 seats
        System.out.println("Get Theatre screen seats name T1 S1 : ");
        List<Seat> seats = theatreController.getTheatre("T1").getScreens().get(0).getSeats();
        for (Seat seat : seats)
            System.out.println(seat.getId());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String show1Id = "";
        try {
            Date date = formatter.parse("2026-04-09");
            show1Id = showController.createShow("Show1", "M1", "S1", date, 1000);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Show show = showController.getShow(show1Id);

        List<String> listOfSeatsToBook = new ArrayList<>();
        listOfSeatsToBook.add("A1");
        listOfSeatsToBook.add("A2");
        String bookingId = bookingController.createBooking("B1", show1Id, "U1", listOfSeatsToBook);

        System.out.println(bookingId);

        List<Booking> bookings = bookingController.getAllBookings();
        Booking booking = bookings.get(0);

        System.out.println("Booking details :");
        System.out.println("Booking Id : " + booking.getId());
        System.out.println("Booking Show : " + booking.getShow().getId());
        System.out.println("Booking Show : " + booking.getShow().getMovie().getName());
        System.out.println("Booking Show : " + booking.getShow().getScreen().getName());
        System.out.println("Booking Show : " + booking.getShow().getStartTime());
        System.out.println("Booking Show : " + booking.getShow().getDurationInSeconds());
        System.out.println("Booking Seats : " + booking.getSeatsBooked());
        System.out.println("Booking User : " + booking.getUser().getName());
        System.out.println("Booking Status : " + booking.getStatus());












    }

}
