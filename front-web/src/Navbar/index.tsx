import './styles.css';
import { ReactComponent as Logo } from './logo.svg';
import Home from '../Home';
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <nav className="main-navbar">
        <Logo />
        <Link to="/" href="home" className="logo-text">DS Delivery</Link>
        </nav>
    )
}

export default Navbar;