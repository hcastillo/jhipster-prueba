package prueba.bith.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.bith.net.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
