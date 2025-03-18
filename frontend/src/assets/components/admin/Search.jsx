import { LuSearch } from "react-icons/lu";

export default function Search() {
  return (
    <form>
      <div className="bg-light flex w-full items-center gap-5 rounded-lg p-2 lg:w-2xl">
        <LuSearch stroke="gray" />
        <input
          type="search"
          placeholder="search"
          className="placeholder:text-gray text-gray w-full border-0 outline-0"
        />
      </div>
    </form>
  );
}
