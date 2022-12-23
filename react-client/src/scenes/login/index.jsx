import React, { useState } from 'react';
import { Box, Button, TextField, Typography } from '@mui/material';
import { useTheme } from '@mui/material/styles';
import { tokens } from '../../theme';


const Login = () => {

    const theme = useTheme();
    const colors = tokens(theme.palette.mode);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email, password);
    }

    return (
        <Box
            sx={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '100vh',
                backgroundColor: colors.primary[400],
            }}
        >
            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center',
                    width: '400px',
                    height: '400px',
                    backgroundColor: colors.primary[500],
                    borderRadius: '10px',
                }}
            >
                <Typography variant="h4" sx={{ color: colors.primary[100] }}>
                    Login
                </Typography>
                <TextField
                    sx={{ width: '80%', marginTop: '20px' }}
                    label="Email"
                    variant="outlined"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <TextField
                    sx={{ width: '80%', marginTop: '20px' }}
                    label="Password"
                    variant="outlined"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <Button
                    sx={{ width: '80%', marginTop: '20px' }}
                    variant="contained"
                    type="submit"
                >
                    Login
                </Button>
            </Box>
        </Box>
    );
};

export default Login;