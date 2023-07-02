package rogerio.pst.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import rogerio.pst.entities.Ativo;

@RegisterForReflection
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
