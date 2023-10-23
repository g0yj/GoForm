import { Link } from 'react-router-dom'
import styles from '../css/header.css';
export default function Header( props ){
    return(<>
        <header>
            <div className="logo">로고</div>
            <div className="menuBox">
                <div className="top">
                    <ul>
                        <li>회원가입</li>
                        <li>로그인</li>
                        <li>로그아웃</li>
                    </ul>
                </div>
                <div className="bottom">
                    <li>폼작성</li>
                    <li>업체</li>
                </div>
            </div>
        </header>
        </>)
    }
