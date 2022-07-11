import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';
import DropdownComponent from './DropdownComponent';

export default function AddSongsComponent() {
   

  return (
    <div style={{ display: 'block', 
                  width: 700, 
                  padding: 30 }}>
      <h4>ADD SONGS</h4>
      <Form>
      <Form.Group>
          <Form.Label>SONG NAME:</Form.Label>
          <Form.Control type="text" 
                        placeholder="Enter song name" />
        </Form.Group>
        <Form.Group>
          <Form.Label>DATE RELEASED</Form.Label>
          <Form.Control type="text" 
                        placeholder="Enter the date released" />
        </Form.Group>
        <Form.Group>
          <Form.Label>Select Artsis:</Form.Label>
          {/*<Form.Control type="number" placeholder="Enter your age" />*/}
          <DropdownComponent/>
        </Form.Group>
        <Form.Group controlId ="formFile" className = "mb-3">
            <Form.Label>UPLOAD THE COVER IMAGE</Form.Label>
            <Form.Control type = "file"/>

        </Form.Group>
        <Button variant="primary" type="submit">
           Click here to submit form
        </Button>
      </Form>
    </div>
  );
}

