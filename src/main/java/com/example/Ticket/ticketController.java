package com.example.Ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ticketController {

    HashMap<String,Ticket> map = new HashMap<>();

    @PostMapping("/bookTicket")
    public void bookTicket(@RequestBody Ticket ticket){
        String ticketId = UUID.randomUUID().toString();

        map.put(ticketId,ticket);


    }
    @GetMapping("/getTicket")
    public Ticket getTicket(@RequestParam("ticketId")String ticketId){
        Ticket ticket =map.get(ticketId);

        return ticket;

    }

    @PutMapping("/updateTicket")
    public void updateTicket(@RequestParam("ticketId")String ticketId,@RequestBody Ticket ticket){
        if(map.containsKey(ticketId)){
            map.put(ticketId,ticket);
        }

        else {
            System.out.println("Update ticket");
        }
    }

    @DeleteMapping("/Delete")
    public void Delete(@RequestParam("ticketId")String ticketId){
         Ticket cancelTicket=map.remove(ticketId);
         if(cancelTicket !=null){
             System.out.println("Ticket has been successfully cancel");
         }

         System.out.println("Ticket not be exist in data base");


    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        List<Ticket> All = new ArrayList<>();

        for(Ticket ticket:map.values()){
            All.add(ticket);
        }
        return  All;
    }

    // Assign ticket to a different passenger
    @PutMapping("/assign")
    public ResponseEntity<String> assignTicket(@RequestParam("ticketId") String ticketId, @RequestParam("newPassengerName") String newPassengerName) {
        Ticket ticket = map.get(ticketId);
        if (ticket != null) {
            ticket.setPassengerName(newPassengerName);
            map.put(ticketId, ticket);
            return ResponseEntity.ok("Ticket assigned to new passenger successfully. Ticket ID: " + ticketId);
        } else {
            return ResponseEntity.status(404).body("Ticket not found for ID: " + ticketId);
        }
    }

    // Search tickets by passenger name
    @GetMapping("/searchByPassenger")
    public ResponseEntity<List<Ticket>> searchByPassenger(@RequestParam("passengerName") String passengerName) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> passengerName.equals(ticket.getPassengerName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    // Search tickets by train number
    @GetMapping("/searchByTrain")
    public ResponseEntity<List<Ticket>> searchByTrain(@RequestParam("trainNumber") String trainNumber) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> trainNumber.equals(ticket.getTrainNo()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by departure station
    @GetMapping("/searchByDepartureStation")
    public ResponseEntity<List<Ticket>> searchByDepartureStation(@RequestParam("departureStation") String departureStation) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> departureStation.equals(ticket.getDepartureStation()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by arrival station
    @GetMapping("/searchByArrivalStation")
    public ResponseEntity<List<Ticket>> searchByArrivalStation(@RequestParam("arrivalStation") String arrivalStation) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> arrivalStation.equals(ticket.getArrivalStation()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by departure time
    @GetMapping("/searchByDepartureTime")
    public ResponseEntity<List<Ticket>> searchByDepartureTime(@RequestParam("departureTime") String departureTime) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> departureTime.equals(ticket.getDepartureTime()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by arrival time
    @GetMapping("/searchByArrivalTime")
    public ResponseEntity<List<Ticket>> searchByArrivalTime(@RequestParam("arrivalTime") String arrivalTime) {
        List<Ticket> tickets = map.values().stream()
                .filter(ticket -> arrivalTime.equals(ticket.getArrivalTime()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(tickets);
    }
}
