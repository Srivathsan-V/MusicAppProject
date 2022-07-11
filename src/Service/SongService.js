import axios from 'axios';

const Song_API_BASE_URL = "http://localhost:9090/songscontroller/viewsongs";

class SongService {

    getSongs(){
        return axios.get(Song_API_BASE_URL);
    }
    getArtists(){
        return axios.get("http://localhost:9090/artistsController/viewArtists")
    }

}

export default new SongService()