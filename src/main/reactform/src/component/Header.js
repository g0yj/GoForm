import { Link } from 'react-router-dom'
import styles from '../css/header.css';

//로고 이미지 호출
//import logoimg from '/'

export default function Header( props ){
    return(<>
        <header>
            <Link to='/'>
                <div className="logo">로고
                    {/*
                    <img src={logoimg} className=""/>
                    */}
                </div>
            </Link>

            <div className="menuBox">
                <ul>
                    <li>회원관리</li>
                    <li>거래처관리</li>
                    <li>제품관리</li>
                    <li>주문관리</li>
                    <li>재고관리</li>
                    <li>발주관리</li>
                    <li>일정관리</li>
                </ul>

            </div>
        </header>
        </>)
    }
