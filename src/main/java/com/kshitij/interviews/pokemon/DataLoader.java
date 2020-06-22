package com.kshitij.interviews.pokemon;

import com.kshitij.interviews.pokemon.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Slf4j
public class DataLoader implements InitializingBean {

    private DataRepository dataRepository;

    // Resources to the different files we need to load.
    @Value("classpath:data/someCharacters.txt")
    private Resource initialLoader;

    public DataLoader(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Load the list of characters and their descriptions
     * @throws Exception In case something goes wrong while we load the breeds.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        loadCharacters(initialLoader);
    }

    /**
     * Reads the list of characters and descriptions and (eventually) add
     * them to the data source.
     * @param source The file holding the breeds.
     * @throws IOException In case things go horribly, horribly wrong.
     */
    private void loadCharacters(Resource source) throws IOException {
        log.debug("Loading breed ");
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                log.debug(line);
                String [] lineDetails= line.split(",");
                dataRepository.addCharacter(lineDetails[0],lineDetails[1].trim());
            }
        }
    }
}
