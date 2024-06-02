import * as React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import { Container ,Paper,Button} from '@mui/material';
import TextField from '@mui/material/TextField';
import { makeStyles } from '@material-ui/makeStyles';
const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1),
       
      },
    },
  }));
  
  export default function Profile() {
      const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
      const[name,setName]=useState('')
      const[address,setAddress]=useState('')
       const classes = useStyles();
  
    const handleClick=(e)=>{
      e.preventDefault()
      const student={name,address}
      console.log(student)
  }
  
    return (
  
      <Container>
          <Paper elevation={3} style={paperStyle}>
              <h1 style={{color:"blue"}}><u>Add Student</u></h1>
  
      <form className={classes.root} noValidate autoComplete="off">
      
        <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth 
        value={name}
        onChange={(e)=>setName(e.target.value)}
        />
        <TextField id="outlined-basic" label="Student Adress" variant="outlined" fullWidth
        value={address}
        onChange={(e)=>setAddress(e.target.value)}
        />
        <Button variant="contained" color="secondary" onClick={handleClick}>
    Submit
  </Button>
      </form>
     
  
  
      </Paper>
  
  
  
      </Container>
    );
  }