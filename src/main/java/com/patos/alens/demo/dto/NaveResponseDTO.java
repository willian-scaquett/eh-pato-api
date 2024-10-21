package com.patos.alens.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.entity.TripulanteEntity;
import com.patos.alens.demo.enumerated.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;
@JsonSerialize
public class NaveResponseDTO {
    private String nomeNave;
    private CorNave corNave;
    private LocalQueda localQuedaNave;
    private String armamentoNave;
    @Schema(example = "LAGRIMAS_DE_UNICORNIO")
    private TipoCombustivel tipoCombustivel;
    private List<TripulanteEntity> listaDeTripulantes;
    @Schema(example = "PERDA_TOTAL")
    private GrauAvaria grauAvaria;
    @Schema(example = "AVANCADA")
    private PotencialTecnologico potencialTecnologico;
    @JsonIgnore
    private LocalDateTime criadoEm;
    @JsonIgnore
    private LocalDateTime atualizadoEm;
    private Long totalTripulantes;
    private Long totalTripulantesMortos;
    public String getNomeNave() {
        return nomeNave;
    }

    public void setNomeNave(String nomeNave) {
        this.nomeNave = nomeNave;
    }

    public CorNave getCorNave() {
        return corNave;
    }

    public void setCorNave(CorNave corNave) {
        this.corNave = corNave;
    }

    public LocalQueda getLocalQuedaNave() {
        return localQuedaNave;
    }

    public void setLocalQuedaNave(LocalQueda localQuedaNave) {
        this.localQuedaNave = localQuedaNave;
    }

    public String getArmamentoNave() {
        return armamentoNave;
    }

    public void setArmamentoNave(String armamentoNave) {
        this.armamentoNave = armamentoNave;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public List<TripulanteEntity> getListaDeTripulantes() {
        return listaDeTripulantes;
    }

    public void setListaDeTripulantes(List<TripulanteEntity> listaDeTripulantes) {
        this.listaDeTripulantes = listaDeTripulantes;
    }

    public GrauAvaria getGrauAvaria() {
        return grauAvaria;
    }

    public void setGrauAvaria(GrauAvaria grauAvaria) {
        this.grauAvaria = grauAvaria;
    }

    public PotencialTecnologico getPotencialTecnologico() {
        return potencialTecnologico;
    }

    public void setPotencialTecnologico(PotencialTecnologico potencialTecnologico) {
        this.potencialTecnologico = potencialTecnologico;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }


    public Long getTotalTripulantes() {
        return totalTripulantes;
    }

    public void setTotalTripulantes(Long totalTripulantes) {
        this.totalTripulantes = totalTripulantes;
    }

    public Long getTotalTripulantesMortos() {
        return totalTripulantesMortos;
    }

    public void setTotalTripulantesMortos(Long totalTripulantesMortos) {
        this.totalTripulantesMortos = totalTripulantesMortos;
    }
    public NaveResponseDTO(PotencialTecnologico potencialTecnologico, GrauAvaria grauAvaria, List<TripulanteEntity> listaDeTripulantes, TipoCombustivel tipoCombustivel, String armamentoNave, LocalQueda localQuedaNave, CorNave corNave, String nomeNave) {
        this.potencialTecnologico = potencialTecnologico;
        this.grauAvaria = grauAvaria;
        this.listaDeTripulantes = listaDeTripulantes;
        this.tipoCombustivel = tipoCombustivel;
        this.armamentoNave = armamentoNave;
        this.localQuedaNave = localQuedaNave;
        this.corNave = corNave;
        this.nomeNave = nomeNave;
    }
    public NaveResponseDTO() {
    }

}
