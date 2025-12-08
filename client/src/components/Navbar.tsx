import logo from "../assets/logo.png"
import useCurrentLocation from "../hooks/useCurrentLocation"
import LocationOnOutlinedIcon from '@mui/icons-material/LocationOnOutlined';
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';

const Navbar: React.FC = () => {
  const { city, postalCode, state } = useCurrentLocation();

  return (
    <div className="flex h-[4.5em] items-center bg-blue-200 gap-[1.5em] ">
      <img src={logo} className="w-[10em] ml-2"/>
      <div id="user-location" className="flex items-end gap-[5px] p-1">
        <LocationOnOutlinedIcon className="!text-[25px] mb-1"/>
        <div className="flex flex-col">
          <p className="text-black/65 text-md font-medium">Deliver to</p>
          <p className="text-md font-bold">{city}, {state} {postalCode} </p>
        </div>
      </div>
      <div id="search-box" className="rounded-md h-[50%] mt-2 border-1 border-[rgba(148, 163, 184, 0.4)]">
        <input type="text" className="outline-none p-1 min-w-[50vw] bg-white rounded-tl-md rounded-bl-md h-full placeholder:text-gray-500 placeholder:italic" placeholder="Search Products"/>
        <button className="relative bg-blue-600 px-3 py-1 h-full cursor-pointer text-white hover:shadow-[0_6px_14px_rgba(37, 99, 235, 0.45)] after:absolute after:inset-0 after:bg-transparent hover:after:bg-black/10 rounded-tr-md rounded-br-md">
          <SearchOutlinedIcon className="mt-[-3px]"/>
        </button>
      </div>
    </div>
  )
}

export default Navbar