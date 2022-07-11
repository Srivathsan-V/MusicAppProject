import React, { useEffect, useState } from 'react';
import SongService from '../Service/SongService';
function ViewArtistsComponent(){
        const[Artists,setArtists] = useState([]);
       
    useEffect(()=>{

    SongService.getArtists().then( res => {
        setArtists(res.data)
        console.log(Artists)
        

    })

},[])
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
             <h3>TOP 10 ARTISTS</h3>
             <div id = "order-table" className = "row">
             <table style={{marginLeft:"30px"}} className="table table-dark table-hover">


                        <thead>
                            <tr>
                                <th> NAME</th>
                                <th>DATE OF BIRTH</th>
                                <th>BIO</th>
                                <th>SONGS</th>
                            </tr>
                        </thead>
                        <tbody>
                           
                                    {
                                       Artists.map((
                                        o)=>
                                
                                    
                                    <tr key = {o.name}>
                                         <td> {o.name} </td>
                                         <td>{o.dob}</td>
                                         <td>{o.bio}</td>
                                         <td><ol>
                                             {

                                             o.songs.map((p)=>

                                             <li>{p.songname}</li>
                                             )}
                                             
                                         </ol>

                                         </td>
                                         
                                        
                                    </tr>
                                    )}
    
                                       
                                    
     
                                    
                                    
                                

                        </tbody>
                            
                    </table>

             </div>

        </div>
        </div>
    )
}


export default ViewArtistsComponent;