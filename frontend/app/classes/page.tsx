"use client";

import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";
import { Button } from "@/components/ui/button";
import { Calendar, Clock, MapPin, User as UserIcon } from "lucide-react";
import { motion } from "framer-motion";
import Link from "next/link";

const classes = [
    {
        id: 1,
        title: "Morning Yoga Flow",
        trainer: "Sarah Lee",
        time: "07:00 AM - 08:00 AM",
        location: "Studio A",
        intensity: "Low",
        slots: 5,
    },
    {
        id: 2,
        title: "HIIT Blast",
        trainer: "Mike Chen",
        time: "06:00 PM - 07:00 PM",
        location: "Main Floor",
        intensity: "High",
        slots: 12,
    },
    {
        id: 3,
        title: "Powerlifting 101",
        trainer: "Alex Johnson",
        time: "08:00 PM - 09:30 PM",
        location: "Weight Zone",
        intensity: "High",
        slots: 0, // Waitlist
    },
];

export default function ClassesPage() {
    return (
        <main className="min-h-screen bg-background">
            <Navbar />

            <section className="pt-32 pb-20 px-4">
                <div className="container mx-auto text-center mb-16">
                    <h1 className="text-4xl md:text-6xl font-bold mb-6">
                        Class <span className="text-primary">Schedule</span>
                    </h1>
                    <p className="text-xl text-muted-foreground max-w-2xl mx-auto">
                        Join our high-energy group sessions. Book your spot today.
                    </p>
                </div>

                <div className="container mx-auto max-w-4xl space-y-6">
                    {classes.map((cls, index) => (
                        <motion.div
                            key={cls.id}
                            initial={{ opacity: 0, x: -20 }}
                            animate={{ opacity: 1, x: 0 }}
                            transition={{ delay: index * 0.1 }}
                            className="group bg-card rounded-xl p-6 border hover:border-primary/50 transition-all duration-300 flex flex-col md:flex-row items-center justify-between gap-6 hover:shadow-lg"
                        >
                            <div className="flex-1 space-y-3 text-center md:text-left">
                                <div className="flex flex-col md:flex-row md:items-center gap-2 md:gap-4 mb-2">
                                    <h3 className="text-2xl font-bold text-foreground group-hover:text-primary transition-colors">
                                        {cls.title}
                                    </h3>
                                    <span className={`px-2 py-1 rounded text-xs font-semibold w-fit mx-auto md:mx-0 ${cls.intensity === 'High' ? 'bg-red-500/10 text-red-500' : 'bg-green-500/10 text-green-500'}`}>
                                        {cls.intensity} Intensity
                                    </span>
                                </div>

                                <div className="flex flex-wrap items-center justify-center md:justify-start gap-4 text-sm text-muted-foreground">
                                    <div className="flex items-center gap-1">
                                        <Clock className="w-4 h-4" /> {cls.time}
                                    </div>
                                    <div className="flex items-center gap-1">
                                        <UserIcon className="w-4 h-4" /> {cls.trainer}
                                    </div>
                                    <div className="flex items-center gap-1">
                                        <MapPin className="w-4 h-4" /> {cls.location}
                                    </div>
                                </div>
                            </div>

                            <div className="flex flex-col items-center gap-2 min-w-[140px]">
                                <div className="text-sm font-medium">
                                    {cls.slots > 0 ? (
                                        <span className="text-primary">{cls.slots} spots left</span>
                                    ) : (
                                        <span className="text-orange-500">Waitlist Only</span>
                                    )}
                                </div>
                                <Button className="w-full bg-secondary hover:bg-secondary/90 text-white" disabled={cls.slots === 0}>
                                    {cls.slots > 0 ? "Book Now" : "Join Waitlist"}
                                </Button>
                            </div>
                        </motion.div>
                    ))}
                </div>
            </section>

            <Footer />
        </main>
    );
}
