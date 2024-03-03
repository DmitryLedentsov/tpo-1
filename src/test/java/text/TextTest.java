package text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import tpo.lab1.text.Assistant;
import tpo.lab1.text.Captain;
import tpo.lab1.text.Gender;
import tpo.lab1.text.Panel;
import tpo.lab1.text.Person;
import tpo.lab1.text.Quolity;
import tpo.lab1.text.Ship;

public class TextTest {
    Ship ship;
    Captain mainHero;
    Assistant trillian;
    Panel panel;
    @BeforeEach
    void init(){
        ship = new Ship("корабль");
        panel = new Panel();
        ship.setControlPanel(panel);
        mainHero = new Captain("главный герой");
        trillian = new Assistant("Триллиан");
        ship.addCrewMember(mainHero);
        ship.addCrewMember(trillian);
        mainHero.getQuolities().addAll(Arrays.asList(Quolity.ARROGANCE, Quolity.BRAVADO, Quolity.IMPETUOSITY));
        trillian.getQuolities().add(Quolity.WISE);
    }


    //проверяем если главный герой барабанит пальцами-->панель ломается-> корабль взрывается -> все умирают
    @Test
    void testCompleteActionsInSleep() {
        mainHero.drumWithFingers(panel);
        assertTrue(ship.isDestroyed());
        assertTrue(panel.isDestroyed());
        assertTrue(mainHero.isDestroyed());
        assertTrue(trillian.isDestroyed());

    }

    //может ли Триллиан остановить героя и спасти корабль
    @ParameterizedTest
    @CsvSource(value = {
        "10,20",
        "20,30",
        "50,40"
    })
    void checkAssistantCanStopCaptain(int captainStrength, int assistantStrength){
        mainHero.setStrength(captainStrength);
        trillian.setStrength(assistantStrength);
        assertEquals(trillian.block(mainHero), captainStrength<assistantStrength);
    }

    

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(OrderAnnotation.class) 
    class CrewTest{
        List<Person> test;
        @BeforeEach
        void init(){
            test = ship.getCrew().stream()
                .collect(Collectors.toList());
        }


        @Order(1)
        @ParameterizedTest
        @MethodSource("personGenerator")
        void testAdd(Person p){
            test.add(p);
            ship.addCrewMember(p);
            assertIterableEquals(test, ship.getCrew());
        }

        @Order(2)
        @ParameterizedTest
        @MethodSource("personGenerator")
        void testContains(Person p){
            ship.addCrewMember(p);
            assertTrue(ship.containsCrewMember(p));
        }
        
        private  Stream<Arguments> personGenerator() {
         return Stream.of(
           Arguments.of(new Person("костя")),
           Arguments.of(new Person("саня")),
           Arguments.of(new Person("абоба", Arrays.asList(Quolity.ARROGANCE), Gender.MALE, 1)));
        }

    }
}
