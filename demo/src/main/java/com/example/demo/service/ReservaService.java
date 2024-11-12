package com.example.demo.service;

import com.example.demo.entity.Reserva;
import com.example.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Buscar todas as reservas
    public List<Reserva> findAllReservas() {
        return reservaRepository.findAll();
    }

    // Buscar reserva por ID
    public Optional<Reserva> findReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    // Salvar uma nova reserva
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Excluir uma reserva
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
