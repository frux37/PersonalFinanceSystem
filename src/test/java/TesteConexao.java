/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vanessalagomachado
 */
public class TesteConexao {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteConexao() {
        // Criar o EntityManager antes de cada teste
        emf = Persistence.createEntityManagerFactory("pu-concessionaria");
        em = emf.createEntityManager();
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
