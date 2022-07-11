import './App.css';
import ViewSongsComponent from './Components/ViewSongsComponent';
import ViewArtistsComponent from './Components/ViewArtistsComponent';
import {BrowserRouter, Route,Routes} from 'react-router-dom';
import AddSongsComponent from './Components/AddSongsComponent';



function App() {
  return (
    <BrowserRouter>      
      <Routes>
      <Route exact path='/songs' element={<ViewSongsComponent/>}></Route>

        <Route exact path='/artists' element={<ViewArtistsComponent/>}></Route>
        <Route exact path='/addsongs' element={<AddSongsComponent/>}></Route>

      </Routes>
      </BrowserRouter>

  );
}

export default App;
