import {useEffect} from "react";
import {BrowserRouter, Route, Routes } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import Login from "./Pages/Login";
import PublicQuestions from "./Pages/PublicQuestions";
import ForumPage from "./Pages/ForumPage";
import NavbarComponent from "./Header/NavbarComponent";

function App() {

    useEffect(() => {
            const requestBody = {
                "email": "vardenis@test.lt",
                "password": "user"
            };

            fetch("login", {
                headers: {
                    "Content-Type": "application/json",
                },
                method: "post",
                body: JSON.stringify(requestBody),
            }).then((response) => response.json())
                .then((data) => console.log(data))
        },
        []);


    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<HomePage/>}/>
                <Route path='api/questions' element={<PublicQuestions/>}/>
                <Route path='api/forum' element={<ForumPage/>}/>
            </Routes>
                <h1>Habitify</h1>
                <p>Log in to access member features</p>
                <Login/>
                <NavbarComponent/>
            </BrowserRouter>
    );

}

export default App;
