import { BrowserRouter, Routes, Route } from'react-router-dom';
import Header from './Header';
import Main from './Main'

export default function Index( props ){
    return(<>
        <div className="webContainer">

            <BrowserRouter>
                <Header/>
                <Routes >
                    {/*Main*/}
                    <Route path='/' element = { <Main /> } />
                </Routes >
            </BrowserRouter>





        </div>
        </>)
    }
