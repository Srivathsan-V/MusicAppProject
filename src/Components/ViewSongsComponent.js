import React, { useEffect, useState } from 'react';
import SongService from '../Service/SongService';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import AddSongsComponent from './AddSongsComponent';


function ViewSongsComponent(){
        const[song,setSong] = useState([{}]);
        let [artist,setArtist] = useState([{}]);
        let [name,setName] = useState("")
       
        const navigate = useNavigate();

        const navigateToAddSongs = () => {
          // 👇️ navigate to /contacts
          navigate('/addsongs');
        };
          
    useEffect(()=>{

    SongService.getSongs().then( res => {
        console.log(res.data)
        setSong(res.data)
        console.log(song)
        console.log(song.songname)
        

    })

},[]);
    {/*const getArtistBySongname = name = {
        axios
        .get(`http://localhost:9090/artistsController/viewArtist/${name}`)
        .then(d=>{
            let c = d.data;
            setArtist(c);
        })
    };*/}
return (
        <div>
            <header>
                    <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                    <div id = "ordernavtitle" className ="navtitle">
                        <a className="navbar-brand">MUSIC APP</a></div>
                    </nav>
                </header>
            <div id = "b-img" style={{ backgroundImage: `url(https://img.freepik.com/premium-photo/wireless-sound-audio-headphones-colored-banner-background-music-app-listening-podcasts-r_90380-3186.jpg?w=2000)`,
                           backgroundSize:'cover',
                           height:'800px'
                        }}>
             <h1 id = "order-dashboard" className="text-center">MY MUSIC APP</h1>
             <br></br>
             <div  id = "order-table" className = "row">
              <div>  <Button  onClick = {navigateToAddSongs} id = "addsongs"variant="outline-dark">+Add Song </Button>
            </div>
            <h3 id = "section-title">TOP 10 SONGS</h3>

             <table style={{marginLeft:"30px"}} className="table table-dark table-hover">


                        <thead>
                            <tr>
                                <th>COVER IMAGE</th>
                                <th>SONG NAME</th>
                                <th>DATE OF RELEASE</th>
                                <th>ARTISTS</th>
                                <th>RATING</th>
                            </tr>
                        </thead>
                        <tbody>
                           
                                    {
                                       song.map((
                                        o)=>
                                
                                    
                                    <tr key = {o.songname}>
                                         <td> <a target="_blank" href={o.cover_image}>
                                             <img id="thumbnail" src={o.cover_image} style={{width: "50px"}}/>
                                             </a></td>
                                         
                                         <td>{o.songname}</td>
                                         <td>{o.date_of_release}</td>
    
                                         <td>
                                            {/*{
                                                useEffect(()=>{
                                                    setName(o.songname);
                                                    getArtistBySongname(name);

                                                },[])
                                            }*/}
                                            
                                          

                                            
                                         
                                           {/* <ol>
                                             {
                                                


                                             artist.map((p)=>

                                             <li>{p}</li>
                                             )}
                                             
                                         </ol>*/}

                                         </td>
                                         <td> {o.avg_rating}</td>
                                        
                                    </tr>
                                    
                                    )}
    
                                       
                                    
     
                                    
                                    
                                

                        </tbody>
                       
                            
                    </table>

             </div>

        </div>
        </div>
    )
}


export default ViewSongsComponent;