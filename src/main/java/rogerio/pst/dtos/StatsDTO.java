package rogerio.pst.dtos;

import jakarta.inject.Named;
import rogerio.pst.entities.Ativo;

@Named
public class StatsDTO {
	private long userCount;
	private Ativo ativo;
	public long getUserCount() {
		return userCount;
	}
	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}
	public Ativo getAtivo() {
		return ativo;
	}
	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	public StatsDTO(long userCount, Ativo ativo) {
		this.userCount = userCount;
		this.ativo = ativo;
	}

	
}
