import {Container, Nav, Navbar} from "react-bootstrap";
import {NavLink} from "react-router-dom";

const NavbarComponent = () => {
    return (
        <>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand to="/" as={NavLink}>Navbar</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link to="/" as={NavLink}>Home</Nav.Link>
                        <Nav.Link to="/api/forum" as={NavLink}>Forum</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    );
}

export default NavbarComponent;
