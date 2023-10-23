import from ''

export default function Index( props ){
    return(<>
        <div className="webContainer">

            <BrowserRouter>
                <Header/>
                <Routes >
                    <Route path='컴포넌트URL' element = { <컴포넌트명 /> } />
                </Routes >
            </BrowserRouter>





        </div>
        </>)
    }
